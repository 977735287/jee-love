package per.san.common.filter;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import per.san.common.utils.StringUtils;
import per.san.sys.domain.SysPermission;
import per.san.sys.service.ISysPermissionService;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * description: 接口api信息初始化
 *
 * @author Sanchar
 * @date 1/6/2019 15:54
 * lastUpdateBy: Sanchar
 * lastUpdateDate: 1/6/2019 15:54
 */
public class PermissionApiInitFilter {

    ApplicationContext applicationContext;

    ISysPermissionService iSysPermissionService;

    public PermissionApiInitFilter(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        iSysPermissionService = (ISysPermissionService) applicationContext.getBean("sysPermissionServiceImpl");
    }

    public void init() {
        String contextId = applicationContext.getId();
        List<SysPermission> permissionList = Lists.newArrayList();
        final Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(RestController.class);
        beansWithAnnotation.forEach((k, v) -> {
            String resource = StringUtils.camel2Crossline(k);
            String classPath = contextId + "." + resource;
            final RequestMapping var1 = v.getClass().getAnnotation(RequestMapping.class);
            String apiClassPath = "";
            if (var1 != null && var1.value() != null && var1.value().length > 0) {
                apiClassPath = var1.value()[0];
            }
            Method[] methods = v.getClass().getMethods();
            for (Method method : methods) {
                boolean isApi = false;
                String apiPath = apiClassPath;
                String requestMethod = "";
                String[] value;
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    final RequestMapping var2 = method.getAnnotation(RequestMapping.class);
                    value = var2.value();
                    if (value != null && value.length > 0) {
                        apiPath = apiClassPath + value[0];
                    }
                    System.out.println(apiPath);
                    final RequestMethod[] method1 = var2.method();
                    if (method1 != null && method1.length > 0) {
                        for (RequestMethod requestMethod1 : method1) {
                            requestMethod += requestMethod1 + ",";
                        }
                        requestMethod = requestMethod.substring(0, requestMethod.length() - 1);
                    }
                    isApi = true;
                } else if (method.isAnnotationPresent(GetMapping.class)) {
                    final GetMapping var2 = method.getAnnotation(GetMapping.class);
                    value = var2.value();
                    if (value != null && value.length > 0) {
                        apiPath = apiClassPath + value[0];
                    }
                    requestMethod = "get";
                    isApi = true;
                } else if (method.isAnnotationPresent(PostMapping.class)) {
                    final PostMapping var2 = method.getAnnotation(PostMapping.class);
                    value = var2.value();
                    if (value != null && value.length > 0) {
                        apiPath = apiClassPath + value[0];
                    }
                    requestMethod = "post";
                    isApi = true;
                } else if (method.isAnnotationPresent(PutMapping.class)) {
                    final PutMapping var2 = method.getAnnotation(PutMapping.class);
                    value = var2.value();
                    if (value != null && value.length > 0) {
                        apiPath = apiClassPath + value[0];
                    }
                    requestMethod = "put";
                    isApi = true;
                } else if (method.isAnnotationPresent(DeleteMapping.class)) {
                    final DeleteMapping var2 = method.getAnnotation(DeleteMapping.class);
                    value = var2.value();
                    if (value != null && value.length > 0) {
                        apiPath = apiClassPath + value[0];
                    }
                    requestMethod = "delete";
                    isApi = true;
                }
                if (isApi) {
                    final ApiOperation var2 = method.getAnnotation(ApiOperation.class);
                    SysPermission sysPermission = new SysPermission();
                    sysPermission.setDescription(var2.value());
                    String code = classPath + "." + method.getName();
                    sysPermission.setCode(code);
                    sysPermission.setPath(apiPath);
                    sysPermission.setMethod(requestMethod);
                    sysPermission.setAction(method.getName());
                    sysPermission.setServiceName(contextId);
                    sysPermission.setResource(resource);
                    permissionList.add(sysPermission);
                }
            }
        });
        SysPermission permission = new SysPermission();
        permission.setIsDeleted(0);
        List<SysPermission> sysPermissions = iSysPermissionService.queryList(permission);
        List<SysPermission> insertList = Lists.newArrayList();
        List<SysPermission> updateList = Lists.newArrayList();
        permissionList.forEach(item -> {
            for (SysPermission sysPermission : sysPermissions) {
                if (item.getCode().equals(sysPermission.getCode())
                        || (item.getPath().equals(sysPermission.getPath())
                        && item.getMethod().equals(sysPermission.getMethod()))) {
                    item.setId(sysPermission.getId());
                    updateList.add(item);
                    break;
                }
            }
            if (item.getId() == null)
                insertList.add(item);
        });
        if (!insertList.isEmpty()) {
            iSysPermissionService.addBatch(insertList);
        }
        if (!updateList.isEmpty()) {
            iSysPermissionService.updateBatch(updateList);
        }
    }
}
