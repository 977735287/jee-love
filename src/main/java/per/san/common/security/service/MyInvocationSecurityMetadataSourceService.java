package per.san.common.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import per.san.sys.domain.SysPermission;
import per.san.sys.mapper.SysPermissionMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * description:
 *
 * @author Sanchar
 * @date 2/19/2019 20:56
 * lastUpdateBy: Sanchar
 * lastUpdateDate: 2/19/2019 20:56
 */
@Service
public class MyInvocationSecurityMetadataSourceService  implements
        FilterInvocationSecurityMetadataSource {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    private HashMap<String, SysPermission> permissionHashMap = null;

    /**
     * 加载权限表中所有权限
     */
    public void loadResourceDefine(){
        map = new HashMap<>();
        permissionHashMap = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<SysPermission> permissionList = sysPermissionMapper.selectAllProtectPermission();
        for(SysPermission permission : permissionList) {
            array = new ArrayList<>();
            cfg = new SecurityConfig(permission.getCode());
            //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
            array.add(cfg);
            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
            map.put(permission.getCode(), array);
            permissionHashMap.put(permission.getCode(), permission);
        }

    }

    //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(map == null || permissionHashMap == null) loadResourceDefine();
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String code;
        for(Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            code = iterator.next();
            SysPermission permission = permissionHashMap.get(code);
            matcher = new AntPathRequestMatcher(permission.getPath(), permission.getMethod().toUpperCase());
            if(matcher.matches(request)) {
                return map.get(code);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
