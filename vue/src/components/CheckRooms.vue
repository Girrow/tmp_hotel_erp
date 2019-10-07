<template>
  <v-container fluid>
    <v-col cols="12" align="right">
      <v-row>
        <div class="flex-grow-1"></div>
        <v-toolbar class="ml-12" color="green darken-1">
          <v-toolbar-title>Check IN/OUT</v-toolbar-title>
        </v-toolbar>
        <div class="flex-grow-1"></div>
        <v-btn dark color="red">체크인</v-btn>
        <v-btn dark color="primary">체크아웃</v-btn>
      </v-row>
    </v-col>
    <v-col cols="12" v-if="roomArray.length > 0">
      <v-row align="center" justify="space-around" v-for="(z,index) in 5" :key="index">
        <div v-for="item in roomArray[0][index]" :key="item.no">
          <v-btn
            :color="item.color"
            class="ma-2 fontme"
            @click.stop="item.dialog = true"
          >{{item.no}}</v-btn>
          <v-dialog v-model="item.dialog">
            <v-card align="center">
              <v-card-title class="headline">{{item.no}}</v-card-title>
              <v-card-text class="headline">{{item}}</v-card-text>

              <v-card-actions>
                <div class="flex-grow-1"></div>
                <v-btn color="green darken-1" text @click="item.dialog = false">Disagree</v-btn>
                <v-btn color="green darken-1" text @click="item.dialog = false">Agree</v-btn>
              </v-card-actions>
            </v-card>
            
          </v-dialog>
        </div>
      </v-row>
    </v-col>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  data: function() {
    return {
      roomInfo: [],
      roomArray: []
    };
  },
  methods: {
    getAllRoomInfo: function() {
      axios
        .post("/getAllRoomInfo")
        .then(res => {
          console.log(res);
          let test = [[], [], [], [], []];
          res.data.forEach(element => {
            let j = parseInt(element.no / 100) - 1;
            console.log("J =", j);
            // element.color = "primary";
            element.dialog = false;
            if (element.status == "F") {
              element.color = "primary";
            } else {
              element.color = "red";
            }
            test[j].push(element);
          });
          console.log("ROOM ARRAY =", this.roomArray);
          this.roomInfo = res.data;
          this.roomArray.push(test);
        })
        .catch(err => {
          console.log(err);
        });
    }
  },
  mounted: function() {
    this.getAllRoomInfo();
  }
};
</script>

<style scoped>
.fontme {
  font-size: 24px;
}
</style>