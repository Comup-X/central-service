<template>
    <div>
        <p>{{cron.content}}</p>
        <el-row>
            <el-col :span="12">
                <el-button @click="nextTime" type="success">下次提醒</el-button>
            </el-col>
            <el-col :span="12">
                <el-button @click="noLonger" type="warning">不再提醒</el-button>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name:'XNotifyContent',

        props: {
            cron: {
                type: Object,
                require: true
            }
        },

        methods:{
            nextTime(){
                this.$emit('nextTime',this.cron);
            },
            noLonger(){
                this.$emit('noLonger',this.cron);
            }
        }
    }
</script>

<style>

</style>