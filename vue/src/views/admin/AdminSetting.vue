<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12" md="8">
        <v-card dark>
          <v-card-title>진행중인 이벤트</v-card-title>
          <v-divider></v-divider>
          <!-- 
          <v-card-text>
            <v-row>
              <v-chip large class="ma-2" color="indigo" text-color="white">
                <v-avatar left>
                  <v-icon>mdi-account-circle</v-icon>
                </v-avatar>Admin
              </v-chip>

              <div class="flex-grow-1"></div>
            </v-row>
          </v-card-text>
          -->
        </v-card>

        <v-card>
          <v-simple-table dark>
            <template v-slot:default>
              <thead>
                <tr>
                  <th class="text-left fontme text-center">Event</th>
                  <th class="text-left fontme text-center">Writer</th>
                  <th class="text-left fontme text-center">Period</th>
                  <th class="text-left fontme text-center">Delete</th>
                </tr>
              </thead>
              <tbody>
                <tr
                  class="fontmeT"
                  v-for="item in desserts"
                  :key="item.name"
                  @click.stop="item.dialog = true"
                >
                  <td class="fontmeT">{{ item.name }}</td>
                  <td class="fontmeT text-center">{{ item.writer }}</td>
                  <td class="fontmeT text-center">{{ item.startDate }} ~ {{ item.endDate }}</td>
                  <td class="text-center">
                    <v-btn>
                      <v-icon dark>mdi-close</v-icon>
                    </v-btn>
                  </td>
                  <v-dialog v-model="item.dialog" max-width="1200">
                    <v-card align="center">
                      <v-card-title class="headline">{{item.name}}</v-card-title>
                      <v-img
                        :src="item.imgSrc"
                        max-width="500"
                        :lazy-src="'https://picsum.photos/id/11/100/60'"
                      ></v-img>
                      <v-card-text class="headline">{{ item.content }}</v-card-text>

                      <v-card-actions>
                        <div class="flex-grow-1"></div>
                        <v-btn color="green darken-1" text @click="item.dialog = false">Disagree</v-btn>
                        <v-btn color="green darken-1" text @click="item.dialog = false">Agree</v-btn>
                      </v-card-actions>
                    </v-card>
                  </v-dialog>
                </tr>
              </tbody>
            </template>
          </v-simple-table>
        </v-card>
      </v-col>

      <v-col cols="12" md="4">
        <v-card>
          <v-card-title>진행종료 이벤트</v-card-title>
        </v-card>
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="12">
        <v-btn color="lime" @click.stop="dialog = true">이벤트 추가하기</v-btn>
        <v-dialog v-model="dialog" max-width="1200">
          <v-form>
            <v-card align="center">
              <v-card-title class="headline">
                <v-text-field v-model="newEvent.title" required label="Event Title" outlined shaped></v-text-field>
              </v-card-title>
              <!-- <v-img max-width="500" :lazy-src="'https://picsum.photos/id/11/100/60'"></v-img> -->
              <v-card-text class="headline">
                <v-textarea
                  class="fontblack"
                  name="input-7-1"
                  filled
                  label="Comment"
                  auto-grow
                  outlined
                  shaped
                  v-model="newEvent.content"
                ></v-textarea>
              </v-card-text>
              <v-file-input accept="image/*"  multiple label="File input"></v-file-input>
              <v-card-actions>
                <div class="flex-grow-1"></div>
                <v-btn color="green darken-1" text @click="addNewEvent">Agree</v-btn>
                <v-btn color="green darken-1" text @click="dialog = false">Disagree</v-btn>
              </v-card-actions>
            </v-card>
          </v-form>
        </v-dialog>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-card>
          <v-card-title>11</v-card-title>
          <v-divider class="mx-4"></v-divider>
          <v-card-text>22</v-card-text>
          <v-card-text>22</v-card-text>
        </v-card>
      </v-col>
    </v-row>
    <v-row>2</v-row>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      desserts: [],
      dialog: false,
      newEvent: {}
    };
  },
  methods: {
    getEvent: function() {
      axios
        .post("/getEventList")
        .then(res => {
          res.data.forEach(function(element) {
            element.dialog = false;
          });
          this.desserts = res.data;
          // console.log("desserts = ",this.desserts);
        })
        .catch(err => {
          console.log(err);
        });
    },
    addNewEvent: function() {}
  },
  mounted: function() {
    this.getEvent();
  }
};
</script>

<style scoped>
.fontme {
  font-family: "Nanum Pen Script", cursive;
  font-size: 140% !important;
}

.fontmeT {
  font-size: 20px;
}
</style>
