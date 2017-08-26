import Vue from 'vue';
import VueRouter from 'vue-router';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-default/index.css';

import App from './App.vue';
import routes from './routes';
import axios from 'axios';

//使用VueRouter前端路由
Vue.use(VueRouter);
//使用ElementUI界面框架
Vue.use(ElementUI);

//设置后台基础IP地址
axios.defaults.baseURL = 'http://127.0.0.1:8081';
//设置请求头
// axios.defaults.headers.post['Content-Type'] = 'multipart/form-data';
//添加axios到Vue全局变量中
Vue.prototype.axios = axios;

//设置路由
const router = new VueRouter({routes});

//挂载Vue到index.html中id=app的div中
new Vue({
    router,
    render: h => h(App)
}).$mount('#app');