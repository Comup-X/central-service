<template>
    <div style="width: 100%;height: 100%">
        <iframe ref="frame" width="100%" height="100%" frameborder="0" :src="'http://' + this.$route.params.url"></iframe>
    </div>
</template>

<script>
    export default {
        name: 'Frame',
    }
</script>

<style>

</style>