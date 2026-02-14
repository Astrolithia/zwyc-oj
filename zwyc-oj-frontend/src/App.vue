<template>
  <div id="app">
    <BasicLayout />
  </div>
</template>

<script setup lang="ts">
import BasicLayout from "@/layout/BasicLayout.vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { onMounted } from "vue";

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

router.beforeEach((to) => {
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

<style></style>
