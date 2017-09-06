<template>
    <div style="overflow: auto" ref="main">
        开发中。。。
        <div style="width: 100px;height: 2000px; border: solid 1px red"></div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                images: []
            }
        },

        mounted() {
            this.axios.get('/zuul/file/listFile', {
                params: {
                    currentPage: 1,
                    pageSize: 50,
                    types: 'image'
                }
            }).then(result => {
                debugger;
                for (var i = 0; i < result.content.length; i++) {
                    this.images.push(result.content[i])
                }
            }).catch(error => {
                debugger;
                this.$message({
                    type: 'error',
                    message: error.message
                })
            });
            this.$refs.main.onscroll = function (e) {
                console.log(d)
                debugger;
            }
        }
    }
</script>

<style>

</style>