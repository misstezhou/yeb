package com.mikes.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mikes.server.config.jwt.JwtTokenUtil;
import com.mikes.server.mapper.AdminMapper;
import com.mikes.server.pojo.Admin;
import com.mikes.server.pojo.RespBean;
import com.mikes.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mikes
 * @since 2021-07-22
 */

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 登陆之后返回token
     * @author mikes
     * @date 2021/7/27 16:58
     * @param username, password, code, request
     * @return
     */
    @Override
    public RespBean login(String username, String password,String code,HttpServletRequest request) {
        //验证验证码
        String captcha = (String) request.getSession().getAttribute("captcha");
        if (StringUtils.isEmpty(code)|| !captcha.equals(code)){
            return RespBean.error("验证码填写错误");
        }
        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        System.out.println(username);

        if (null == userDetails || !passwordEncoder.matches(password,userDetails.getPassword())){
            return RespBean.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()){
            return RespBean.error("账号被禁用，联系管理员");
        }

        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String,Object> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return RespBean.success("登陆成功",tokenMap);
    }

    @Override
    public Admin getAdminByUserName(String username) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",username).eq("enabled",true));
    }
}
