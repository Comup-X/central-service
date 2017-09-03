<template>
    <div>
        开发中。。。
        <img src="http://127.0.0.1:8080/zuul/file/downLoad?scheme=file&host=&port=0&path=F://images&fileName=71f43059-bf1e-42fc-be5a-b3d6190f794f.jpg"/>
        <div v-if="gameData.gaming">

        </div>
    </div>
</template>

<script>
    export default {
        name: 'AnimalGame',
        data() {
            return {
                gameData:{
                    gaming:false
                }
            }
        },
        methods:{

        },

        created(){
//            this.axios.get('/')
        }
    }
</script>

<style>

</style>