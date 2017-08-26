<template>
    <div>
        <el-upload
                class="avatar-uploader"
                :action="axios.defaults.baseURL+'/image/upload'"
                :show-file-list="false"
                :on-success="handleAvatarSuccess">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                imageUrl: ''
            }
        },

        methods: {
            handleAvatarSuccess(res, file) {
                if (res.data.code === 0) {
                    this.imageUrl = URL.createObjectURL(file.raw);
                }
            }
        },

        created() {
            console.log("init")
        }
    }
</script>

<style>
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .avatar-uploader .el-upload:hover {
        border-color: #20a0ff;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }

    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
</style>