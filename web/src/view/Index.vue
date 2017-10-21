<template>
    <div style="overflow:auto;">
        <div class="bod mar-t20 mar-b20" v-for="(value,key) in navs">
            <div class="txt-center mar-t20 mar-b20">
                <span >{{key}}</span>
            </div>
            <el-row>
                <el-col :span="computedSpan(value)" v-for="nav in value" :key="nav.id" class="txt-center">
                    <a  :href="navToUrl(nav)">{{nav.name}}</a>
                </el-col>
            </el-row>
        </div>
        <div class="btm txt-center">
            Power by vue and element
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Index',
        data() {
            return {
                navs: {},
            }
        },
        methods: {
            computedSpan(value){
                if(value.length<6){
                    return 24.0/value.length;
                }
                return 4.0;
            },

            navToUrl(nav) {
                let port = "";
                if (!(nav.port <= 0)) {
                    port = ":" + nav.port;
                }
                return nav.protocol + '://' + nav.hostname + port
            }
        },

        created() {
            this.axios.get('/personal-site/index/nav')
                .then(result => {
                    this.navs = result;
                });
        }
    }
</script>

<style>
    .mar-t20{
        margin-top: 20px;
    }

    .mar-b20{
        margin-bottom: 20px;
    }

    .txt-center {
        text-align: center;
    }

    .bod{
        border: 1px solid royalblue;
    }

    .btm{
        position: absolute;
        right: 0;
        left: 0;
        bottom: 0;
    }
</style>