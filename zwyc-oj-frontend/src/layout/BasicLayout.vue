<template>
  <div id="basicLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="header"> <GlobalHeader /> </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer">
        <a href="https://yupi.icu"> 编程导航 by Zwicykc </a>
      </a-layout-footer>
    </a-layout>
  </div>
</template>
/

<script>
import { ref } from "vue";
import GlobalHeader from "@/components/GlobalHeader.vue";

export default {
  components: { GlobalHeader },
  setup() {
    const value = ref(new Date("2023-01-01"));

    return {
      value,
    };
  },
};
</script>
<style scoped>
#basicLayout {
}

#basicLayout .header {
  margin-bottom: 16px;
  box-shadow: #eee 1px 1px 5px;
}

#basicLayout .content {
  background: linear-gradient(to right, #eee, #fff);
  margin-bottom: 16px;
  padding: 20px;
}

#basicLayout .footer {
  background: #efefef;
  padding: 16px;
  position: sticky;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
}
</style>
