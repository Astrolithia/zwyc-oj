import App from "./App.vue";
import router from "./router";
import store from "./store";
import { createApp } from "vue";
import ArcoVue from "@arco-design/web-vue"; // 组件
import "@arco-design/web-vue/dist/arco.css"; // 样式

createApp(App).use(store).use(router).use(ArcoVue).mount("#app");
