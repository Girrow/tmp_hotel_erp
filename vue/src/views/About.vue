<template>
  <div class="about">
    <router-view></router-view>
  </div>
</template>

<script>
import axios from "axios";

export default {
  methods:{
    getUserSession:function(){
      axios.post('/getUserSession').then(res=>{
        console.log("1111",res);
        this.$store.commit('updateUserInfo',res);
      }).catch(err=>{
        console.log(err);
        
      })
    }
  },
  mounted:function(){
    this.getUserSession();
  }
}
</script>

<style scoped>

</style>
