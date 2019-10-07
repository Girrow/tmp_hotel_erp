<template>
  <v-container fluid style="max-width:1500px;margin:0 auto;border:1px solid black">
    <v-row>
      <v-btn class="ma-4" dark router :to="{name:'userBoardCreate'}">글 생성</v-btn>
    </v-row>
    <v-simple-table fixed-header>
      <thead>
        <tr>
          <th class="text-left fontme">No</th>
          <th class="text-left fontme">Type</th>
          <th class="text-left fontme">Title</th>
          <th class="text-left fontme">Writer</th>
          <th class="text-left fontme">Views</th>
          <th class="text-left fontme">Created</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in tableList" :key="item.no" @click="goToDetail(item.no)">
          <td class="fontme">{{ item.no }}</td>
          <td class="fontme">{{ item.selectedType }}</td>
          <td class="fontme">{{ item.title }}</td>
          <td class="fontme">{{ item.writer }}</td>
          <td class="fontme">{{ item.views }}</td>
          <td class="fontme">{{ item.created }}</td>
        </tr>
      </tbody>
    </v-simple-table>
    <v-row>
      <v-col cols="12" justify="center" align="center">
        <div class="text-center">
          <v-pagination v-model="page" :length="pageTotal" :total-visible="7"></v-pagination>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  data: () => ({
    tableList: [],
    page: 1,
    pageTotal: 1,
    submitData: {}
  }),
  watch: {
    page: function() {
      console.log(this.page);
      let postdata = new URLSearchParams();
      postdata.append("page", this.page);
      axios
        .post("/getSmalltalkList", postdata)
        .then(res => {
          console.log("RES:", res);
          this.tableList = res.data.results;
        })
        .catch(err => {
          console.log(err);
        });
    }
  },
  methods: {
    getList: function() {
      // 나중에 페이징 할때 사용할 post값
      let postdata = new URLSearchParams();
      postdata.append("page", this.page);
      axios
        .post("/getSmalltalkList", postdata)
        .then(res => {
          console.log("RES:", res);
          this.tableList = res.data.results;
          this.pageTotal = res.data.totalPage;
          console.log(this.pageTotal);
        })
        .catch(err => {
          console.log(err);
        });
    },
    goToDetail: function(tableNo) {
      this.$router.push({ name: "userBoardDetail", params: { tableNo } });
    },
    pageList: function() {}
  },
  mounted: function() {
    this.getList();
  }
};
</script>

<style scoped>
.fontme {
  font-size: 20px !important;
}
</style>
