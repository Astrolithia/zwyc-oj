<template>
  <div id="app">
    <template v-if="route.path.startsWith('/user')"><router-view /></template>
    <template v-else> <BasicLayout /> </template>
  </div>
</template>

<script setup lang="ts">
import BasicLayout from "@/layout/BasicLayout.vue";
import { useRoute, useRouter } from "vue-router";
import { useStore } from "vuex";
import { onMounted } from "vue";

const route = useRoute();

/**
 * 全局初始化函数，有全局单次调用的代码，都可以写到这里
 */
const doInit = () => {
  console.log("hello 欢迎来到我的项目");
};

onMounted(() => {
  doInit();
});

const router = useRouter();
const store = useStore();

router.beforeEach(async (to) => {
  const loginUser = store.state.user.loginUser;

  // 仅在未获取过用户信息时才请求
  if (loginUser.userName === "未登录") {
    await store.dispatch("user/getLoginUser");
  }
  // 仅管理员可见：无权限则跳转到无权限页
  if (
    to.meta?.access === "canAdmin" &&
    store.state.user.loginUser?.role !== "admin"
  ) {
    return { path: "/noAuth" };
  }
  return true;
});
</script>

<style>
#app {
  background-color: white !important;
}
</style>
