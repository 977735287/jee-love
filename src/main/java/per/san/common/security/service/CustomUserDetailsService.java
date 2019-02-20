package per.san.common.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import per.san.sys.domain.SysPermission;
import per.san.sys.domain.SysUser;
import per.san.sys.mapper.SysPermissionMapper;
import per.san.sys.mapper.SysUserMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author Sanchar
 * @date 2/16/2019 17:15
 * lastUpdateBy: Sanchar
 * lastUpdateDate: 2/16/2019 17:15
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.selectByUsername(username);
        if (sysUser != null) {
            sysUser = sysUserMapper.selectByPrimaryKey(sysUser.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            List<SysPermission> permissionList;
            if (sysUser.getIsAdmin()) {
                permissionList = sysPermissionMapper.selectAllProtectPermission();
                permissionList.forEach(item -> grantedAuthorities.add(new SimpleGrantedAuthority(item.getCode())));
            } else {
                permissionList = sysPermissionMapper.selectPermissionByUserId(sysUser.getId());
                permissionList.forEach(item -> grantedAuthorities.add(new SimpleGrantedAuthority(item.getCode())));
            }
            return new User(sysUser.getUserName(), sysUser.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("user: " + username + " do not exist!");
        }
    }
}
