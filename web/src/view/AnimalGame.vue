<template>
    <div>
        开发中。。。
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