<template>
    <div>
        <el-menu defaultActive="" theme="dark" class="el-menu-demo nav" mode="horizontal" :router="true">
            <el-menu-item index="1" :route="{path:'/frame/https/xlz35429674.3322.org/13000'}">Gogs</el-menu-item>
            <el-menu-item index="2" :route="{path:'/frame/https/xlz35429674.3322.org/18000'}">Seafile</el-menu-item>
            <el-menu-item index="3" :route="{path:'/frame/https/xlz35429674.3322.org/1800'}">Shadowsocks-Manager</el-menu-item>
            <el-menu-item index="4" :route="{path:'/markDown'}">Mark-Down</el-menu-item>
            <el-submenu index="5">
                <template slot="title">Game</template>
                <el-menu-item index="5-1" :route="{path:'/animalGame'}">Animal-Game</el-menu-item>
            </el-submenu>
            <el-submenu index="6">
                <template slot="title">Image</template>
                <el-menu-item index="6-1" :route="{path:'/image/list'}">Gallery</el-menu-item>
                <el-menu-item index="6-2" :route="{path:'/image/upload'}">Image-Upload</el-menu-item>
            </el-submenu>
        </el-menu>
        <div class="content">
            <router-view class="fullParent clean"></router-view>
        </div>
    </div>
</template>

<script>


    export default {
        data() {
            return {}
        },

        methods: {},

        mounted() {
        }
    }
</script>

<style>
    html, body {
        height: 100%;
        margin: 0 0;
        padding: 0 0;
        overflow: hidden;
    }

    .clean {
        margin: 0 0;
        padding: 0 0;
    }

    .nav {
        width: 100%;
        height: 60px;
    }

    .fullParent {
        height: 100%;
        width: 100%;
    }

    .content {
        width: 100%;
        position: absolute;
        top: 60px;
        bottom: 0;
        left: 0;
        right: 0;
    }
</style>