<template>
  <v-container id="test">
    <v-card>
      <v-col class="ma-4 d-flex" cols="12" sm="6">
        <v-btn-toggle>
          <v-btn text value="left">TAG</v-btn>
        </v-btn-toggle>
        <v-select label="Table Select" :items="selectList" menu-props="auto" v-model="userC.select"></v-select>
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
        <v-btn @click="insertData" dark class="ma-1">입력</v-btn>
        <v-btn class="ma-1" router :to="{name:'userBoard'}">취소</v-btn>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
export default {
  data: function() {
    return {
      label: "",
      selectList: ["문의사항", "건의사항", "1:1 문의"],
      userC: {}
    };
  },
  methods:{
    insertData:function(){
      console.log("입력")
    }
  }
}
</script>

<style>

</style>