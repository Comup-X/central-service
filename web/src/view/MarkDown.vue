<template>
    <div style="overflow:auto;">
        开发中。。。
        <el-row class="fullSpace">
            <el-col :span="12">
                <textarea class="fullSpace" v-model="md"></textarea>
            </el-col>
            <el-col :span="12">
                <div class="fullSpace" ref="preview"></div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import marked from 'marked';
    import hljs from 'highlight.js'
    import 'highlight.js/styles/hybrid.css'


    marked.setOptions({
        renderer: new marked.Renderer(),
        gfm: true,
        tables: true,
        breaks: false,
        pedantic: false,
        sanitize: false,
        smartLists: true,
        smartypants: false,
        highlight: function (code) {
            return hljs.highlightAuto(code).value;
        }
    });

    export default {
        data() {
            return {
                md: ''
            }
        },
        watch: {
            md(newValue, oldValue) {
                var htm = marked(newValue);
                console.log(htm);
                this.$refs.preview.innerHTML = htm;
            }
        }
    }
</script>

<style>


    .fullSpace {
        width: 100%;
        height: 100%;
    }
</style>