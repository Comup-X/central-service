<template>
    <div class="bkg-f1f2f6" style="overflow:auto;">
        <div class="bkg-ffffff bod mar-t20 mar-b20" v-for="(value,key) in navs">
            <div class="txt-center mar-b20">
                <span>{{key}}</span>
            </div>
            <el-row class="bkg-ffcfc8">
                <el-col :span="computedSpan(value)" v-for="nav in value" :key="nav.id" class="txt-center">
                    <a :href="navToUrl(nav)">{{nav.name}}</a>
                </el-col>
            </el-row>
        </div>
        <div class="btm txt-center">
            Power by vue and element
        </div>
    </div>
</template>

<script>
    import XNotifyContent from '../component/XNotifyContent.vue'

//    function sleep(n) {
//        const start = new Date().getTime();
//        while (true) if (new Date().getTime() - start > n) break;
//    }

    export default {
        name: 'Index',

        components: {
            'x-nc': XNotifyContent
        },

        data() {
            return {
                //获取计划任务的定时任务
                getCronTimer: 0,
                //执行计划任务的定时任务
                cronTimer: 0,
                //导航信息
                navs: {},
                //计划任务信息
                crons: [],
                //触发过的任务ID
                triggered: [],
            }
        },
        methods: {
            //计算一个导航的宽度
            computedSpan(value) {
                if (value.length < 6) {
                    return 24.0 / value.length;
                }
                return 4.0;
            },
            //nav对象转url
            navToUrl(nav) {
                let port = "";
                if (!(nav.port <= 0)) {
                    port = ":" + nav.port;
                }
                return nav.protocol + '://' + nav.hostname + port
            },
            //得到最新的导航数据
            getNav() {
                this.axios.get('/personal-site/nav')
                    .then(result => {
                        this.navs = result;
                    });
            },
            //得到最新的计划任务
            getCron() {
                console.log('定时获取最新计划任务');
                this.axios.get('/personal-site/cron')
                    .then(result => {
                        this.crons = result;
                    });
            },
            //检查是否有计划任务需要执行
            checkCron() {
//                console.log('检查是否有计划任务需要执行');
//                let now = new Date();
//                for (let i = 0; i < this.crons.length; i++) {
//                    let cron = this.crons[i];
//                    if (now.getTime() - cron.startTime >= 0
//                        && !cron.finished
//                        && this.triggered.indexOf(cron.id)) {
//                        debugger;
//                        const notify = this.$notify({
//                            title: cron.title,
//                            message: this.$createElement('x-nc', {
//                                props: {
//                                    cron: cron
//                                },
//                                on: {
//                                    nextTime: (cron) => {
//                                        this.triggered.push(cron.id);
//                                        notify.close();
//                                    },
//                                    noLonger: (cron) => {
//                                        this.triggered.push(cron.id);
//                                        notify.close();
//                                    }
//                                }
//                            }),
//                            duration: 0,
//                            onClose: () => {
//                                this.triggered.push(cron.id);
//                            }
//                        });
//                    }
//                }
            }
        },

        created() {
            this.getNav();
            this.getCron();
            this.checkCron();
            //定时获取最新的计划任务并检查需要执行的任务
            this.getCronTimer = window.setInterval(() => {
                this.getCron();
                this.checkCron();
            }, 5000);
        },

        destroyed() {
            console.log('执行destroyed');
            window.clearInterval(this.getCronTimer);
            window.clearInterval(this.cronTimer);
        }
    }
</script>

<style scoped>
    .bkg-f1f2f6 {
        /*background: url("../assets/index_background.jpg") no-repeat ;*/
        background-color: #f1f2f6;
    }

    .bkg-ffffff {
        background-color: #ffffff;
    }

    .mar-t20 {
        margin-top: 20px;
    }

    .mar-b20 {
        margin-bottom: 20px;
    }

    .txt-center {
        text-align: center;
    }

    .bod {
        border: 1px solid royalblue;
    }

    .btm {
        position: absolute;
        right: 0;
        left: 0;
        bottom: 0;
    }
</style>