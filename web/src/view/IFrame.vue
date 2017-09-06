<template>
    <iframe ref="frame" frameborder="0" scrolling="auto" width="100%" height="100%" marginheight="0" marginwidth="0"
            :src="this.$route.params.scheme+'://'+this.$route.params.host+':'+this.$route.params.port"></iframe>
</template>

<script>
    export default {
        name: 'Frame',
    }
</script>

<style>

</style>