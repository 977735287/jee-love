package per.san.sys.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.san.common.utils.page.PageRequest;
import per.san.sys.domain.SysMenu;
import per.san.sys.service.ISysMenuService;
import java.util.List;

/**
 * description: 菜单信息表
 *
 * @author sanchar
 * @date 2018-12-28 05:03
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2018-12-28 05:03
 */
@RestController
@RequestMapping("/v1/sys/menu")
public class SysMenuController {

    @Autowired
    ISysMenuService iSysMenuService;

    @ApiOperation(value = "新增")
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody SysMenu sysMenu) {
    return new ResponseEntity<>(iSysMenuService.add(sysMenu), HttpStatus.OK);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iSysMenuService.deleteByPrimaryKey(id), HttpStatus.OK);
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(iSysMenuService.deleteBatch(ids), HttpStatus.OK);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResponseEntity<Integer> update(@RequestBody SysMenu sysMenu) {
        return new ResponseEntity<>(iSysMenuService.update(sysMenu), HttpStatus.OK);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public ResponseEntity<PageInfo<SysMenu>> pageQuery(
            PageRequest pageRequest,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) Long parentId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Long sort,
            @RequestParam(required = false) Integer isDefault,
            @RequestParam(required = false) String icon,
            @RequestParam(required = false) String route
            ) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setName(name);
        sysMenu.setCode(code);
        sysMenu.setLevel(level);
        sysMenu.setParentId(parentId);
        sysMenu.setType(type);
        sysMenu.setSort(sort);
        sysMenu.setIsDefault(isDefault);
        sysMenu.setIcon(icon);
        sysMenu.setRoute(route);
        return new ResponseEntity<>(iSysMenuService.pageQuery(pageRequest, sysMenu), HttpStatus.OK);
    }

    @ApiOperation(value = "查询list")
    @GetMapping
    public ResponseEntity<List<SysMenu>> queryList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) Long parentId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Long sort,
            @RequestParam(required = false) Integer isDefault,
            @RequestParam(required = false) String icon,
            @RequestParam(required = false) String route
            ) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setName(name);
        sysMenu.setCode(code);
        sysMenu.setLevel(level);
        sysMenu.setParentId(parentId);
        sysMenu.setType(type);
        sysMenu.setSort(sort);
        sysMenu.setIsDefault(isDefault);
        sysMenu.setIcon(icon);
        sysMenu.setRoute(route);
        return new ResponseEntity<>(iSysMenuService.queryList(sysMenu), HttpStatus.OK);
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("/{id}")
    public ResponseEntity<SysMenu> queryById(
        @PathVariable("id") Long id) {
        return new ResponseEntity<>(iSysMenuService.queryById(id), HttpStatus.OK);
    }
}
