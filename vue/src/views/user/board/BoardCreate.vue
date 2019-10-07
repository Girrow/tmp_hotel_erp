<template>
  <v-container id="test">
    <v-card>
      <v-col class="ma-4 d-flex" cols="12" sm="6">
        <v-btn-toggle>
          <v-btn text value="left">TAG</v-btn>
        </v-btn-toggle>
        <v-select label="Table Select" :items="selectList" menu-props="auto" v-model="userC.selectedType"></v-select>
      </v-col>

      <v-row class="ma-3">
        <v-col cols="12" sm="6">
          <v-text-field v-model="userC.title" label="Title" outlined shaped></v-text-field>
        </v-col>
      </v-row>
      <v-row class="ma-4">
        <v-col cols="12" md="12">
          <v-textarea
            class="fontblack"
            v-model="userC.content"
            name="input-7-1"
            filled
            label="Comment"
            auto-grow
            value="값을 입력하세요."
          ></v-textarea>
        </v-col>
      </v-row>
      <v-row class="pb-6" justify="center" align="center">
        <v-btn @click="insertData" dark class="ma-1" v-if="this.$route.params.tableNo == undefined"> 입력</v-btn>
        <v-btn @click="updateData" dark class="ma-1" v-else> 수정하기</v-btn>
        <v-btn class="ma-1" router :to="{name:'userBoard'}">취소</v-btn>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  data: function() {
    return {
      label: "",
      selectList: ["문의사항", "건의사항", "1:1 문의"],
      userC: {}
    };
  },
  methods: {
    insertData: function() {
      if (this.userC.title == undefined || this.userC.content == undefined) {
        this.$store.commit('popup', { msg: '제목이나 내용이 비어있습니다.', color: 'primary' })
      } else {
        let postdata = new URLSearchParams();
        postdata.append("title", this.userC.title);
        postdata.append("content", this.userC.content);
        postdata.append("selectedType", this.userC.selectedType);
        postdata.append("writer", this.$store.state.userId);
        console.log(postdata);
        axios
          .post("/board/create",postdata)
          .then(res => {
            if(res.data.status==200){
              this.$router.push({name:'userBoard'});
            }
            console.log(res);
          })
          .catch(err => {
            console.log(err);
          });
      }
    },
    updateData:function(){
      if (this.userC.title == undefined || this.userC.content == undefined) {
        this.$store.commit('popup', { msg: '제목이나 내용이 비어있습니다.', color: 'primary' })
      } else {
        let postdata = new URLSearchParams();
        postdata.append("no", this.$route.params.tableNo);
        postdata.append("title", this.userC.title);
        postdata.append("content", this.userC.content);
        postdata.append("selectedType", this.userC.selectedType);
        postdata.append("writer", this.$store.state.userId);
        console.log(postdata);
        axios
          .post("/board/update",postdata)
          .then(res => {
            if(res.data.status==200){
              this.$router.push({name:'userBoard'});
            }
            console.log(res);
          })
          .catch(err => {
            console.log(err);
          });
      }
    },
    getDetailInfo:function(){
      let postdata= new URLSearchParams();
      postdata.append('key',this.$route.params.tableNo)
      axios.post('/board/detail',postdata).then(res=>{
        console.log(res);
        this.userC=res.data;
      }).catch(err=>{
        console.log(err);
      })
    },
    isItUpdate:function(){
      if(this.$route.params.tableNo != undefined){
        this.getDetailInfo();
      }
    }
  },
  mounted: function() {
    this.isItUpdate();
    // this.insertData();
  }
};
</script>

<style scoped>
#test {
  max-width: 1400px;
}
.fontblack {
  color: black !important;
  min-height: 300px;
}
</style>