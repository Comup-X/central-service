<template>
    <div class="main">
        <el-menu defaultActive="" theme="dark" class="el-menu-demo nav" mode="horizontal" :router="true">
            <el-menu-item index="1" :route="{path:'/frame/xlz35429674.3322.org:3000'}">Gogs</el-menu-item>
            <el-menu-item index="2" :route="{path:'/frame/xlz35429674.3322.org:8000'}">Seafile</el-menu-item>
            <el-menu-item index="3" :route="{path:'/frame/xlz35429674.3322.org:800'}">Shadowsocks-Manager</el-menu-item>
            <el-menu-item index="4" :route="{path:'/animalGame'}">Animal-Game</el-menu-item>
            <el-menu-item index="5" :route="{path:'/markDown'}">Mark-Down</el-menu-item>
            <el-menu-item index="6" :route="{path:'/image/upload'}">Image-Upload</el-menu-item>
        </el-menu>
        <div class="content">
            <router-view></router-view>
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

    .nav {
        /*height: 100px; margin: -60px 0 0;*/
        width: 100%;
        height: 60px;
    }

    .content {
        /*height: 100%;*/
        width: 100%;
        position: absolute;
        top: 60px;
        bottom: 0;
        left: 0;
    }
</style>