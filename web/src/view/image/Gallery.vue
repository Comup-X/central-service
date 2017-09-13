<template>
    <div style="overflow: auto" ref="main">
        <section v-for="item in images">
            <img class="img-box flot-left" :src="getImageUrl(item)"/>
        </section>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                images: []
            }
        },

        methods: {
            getImageUrl(item) {
                debugger;
                let pk = item.fileInfoPK;
                return this.axios.defaults.baseURL + '/zuul/file/downLoad?' +
                    'scheme=' + pk.scheme + '&' +
                    'host=' + pk.host + '&' +
                    'port=' + pk.port + '&' +
                    'path=' + pk.path + '&' +
                    'fileName=' + pk.fileName;
            }
        },

        mounted() {
            let v = this;
            this.axios.get('/zuul/file/listFile', {
                params: {
                    currentPage: 0,
                    pageSize: 50,
                    types: 'image'
                }
            }).then(result => {
                debugger;
                for (var i = 0; i < result.content.length; i++) {
                    v.images.push(result.content[i])
                }
            });
            this.$refs.main.onscroll = function (e) {
                console.log(d);
            }
        }
    }
</script>

<style>
    .img-box {
        max-height: 150px;
    }

    .flot-left {
        float: left;
    }
</style>