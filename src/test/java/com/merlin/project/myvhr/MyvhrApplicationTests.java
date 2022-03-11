package com.merlin.project.myvhr;

import com.merlin.project.myvhr.beans.SysResources;
import com.merlin.project.myvhr.beans.SysRole;
import com.merlin.project.myvhr.beans.SysUser;
import com.merlin.project.myvhr.mapper.SysRoleMapper;
import com.merlin.project.myvhr.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = MyvhrApplication.class)
class MyvhrApplicationTests {

    @Autowired SysRoleMapper roleMapper;
    @Autowired
    SysUserMapper sysUserMapper;

    @Test
    public void testRole(){

        SysRole sysRole = roleMapper.get(1);
        System.out.println("角色的名称："+ sysRole.getRolename());

        List<SysResources> resources = sysRole.getResources();
        for(SysResources res : resources){
            System.out.println("资源的名称： "+ res.getName() + " ， 资源的许可："+ res.getPermission());
        }
    }


    @Test
    public void testUser(){

        SysUser user = new SysUser();
        user.setPassword("root");
        user.setUsername("root");
        SysUser sysUser = sysUserMapper.get(user);

        System.out.println(sysUser );

        List<SysRole> roles = sysUser.getRoles();

        for(SysRole role : roles){
            System.out.println(role );
        }
    }

}
