<template>
  <v-container id="test" style="max-width:1400px;">
    <v-card>
      <v-toolbar flat color="orange" dark>
        <v-row>
          <v-btn router :to="{name:'userBoard'}">
            <v-toolbar-title>
              <v-icon>mdi-arrow-up</v-icon>목록
            </v-toolbar-title>
          </v-btn>
          <div class="flex-grow-1"></div>
          <v-btn v-if="auth" color="primary" router :to="{name:'userBoardCreate',params:{tableNo:this.$route.params.tableNo}}">
            <v-toolbar-title>
              <v-icon>mdi-arrow-right</v-icon>수정
            </v-toolbar-title>
          </v-btn>
          <v-btn v-if="auth" color="red lighten-1" @click="deleteThis">
            <v-toolbar-title>
              <v-icon>mdi-arrow-down</v-icon>삭제
            </v-toolbar-title>
          </v-btn>
        </v-row>
      </v-toolbar>
      <v-form>
        <v-divider></v-divider>
        <v-row>
          <v-btn class="ma-5">
            No
            <v-chip label class="fontme" color="orange">{{this.$route.params.tableNo}}</v-chip>
          </v-btn>
          
          <v-btn class="ma-5">
            Title
            <v-chip label class="fontme" color="blue">{{information.title}}</v-chip>
          </v-btn>

          <div class="flex-grow-1"></div>
          <v-btn justify="right" color="lime" class="ma-5">
            writer
            <v-icon left color="lime lighten-4">mdi-account</v-icon>
            <v-chip class="fontme">{{information.writer}}</v-chip>
          </v-btn>
        </v-row>
        <v-divider></v-divider>
        <v-row class="ma-4">
          <div class="flex-grow-1"></div>{{information.created}},{{information.views}}
        </v-row>
        <v-divider></v-divider>
        <v-textarea
          class="ma-5 display-1 fontblack"
          v-model="information.content"
          label="Message"
          counter
          disabled
          maxlength="200"
          full-width
          single-line
        ></v-textarea>
      </v-form>
    </v-card>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  data: function() {
    return {
      information:{},
      auth:false
    };
  },
  methods: {
    getDetailInfo:function(){
      let postdata= new URLSearchParams();
      postdata.append('key',this.$route.params.tableNo)
      axios.post('/board/detail',postdata).then(res=>{
        console.log(res);
        this.information=res.data;
        if(this.$store.state.userId === this.information.writer ){
          this.auth=true;
        }
      }).catch(err=>{
        console.log(err);
      })
    },
    deleteThis:function(){
      console.log("삭제 눌림");
      let trueOfF=confirm("정말로 삭제하시겠습니까?");
      if(trueOfF){
        let postdata=new URLSearchParams();
        postdata.append('title',this.$route.params.tableNo);
        postdata.append('writer',this.$store.state.userId);
        axios.post('/board/delete',postdata).then(res=>{
          console.log(res);
          this.$router.push({name:'userBoard'});
        }).catch(err=>{
          console.log(err);
        })
        
      }
    }
  },
  mounted: function() {
    this.getDetailInfo();
    // this.getAuth();
  }
};
</script>

<style scoped>
.fontme {
  font-size: 25px !important;
}
.fontblack {
  color: black !important;
  min-height: 300px;
}
</style>