<template>
  <v-container>
    <v-layout text-center wrap>
      <v-col cols="12">
        <div>
          <v-progress-linear stream indeterminate color="cyan"></v-progress-linear>
        </div>
      </v-col>

      <v-col cols="12" md="6">
        <v-card elevation="20">
          <v-flex id="tte">
            <!-- <v-row class="btn" align="center" justify="center">일 통계자료</v-row> -->
            <v-btn color="lime lighten-2" class="mt-4">일별 통계자료</v-btn>
            <v-container class="fill-height" fluid>
              <!-- <v-row align="center" justify="center" style="min-height:500px;"> -->
              <test-line style="width:100%;"></test-line>
              <!-- </v-row> -->
              <!-- <v-row align="center" justify="center"></v-row> -->
            </v-container>
          </v-flex>
        </v-card>
      </v-col>

      <v-col cols="12" md="6">
        <v-card elevation="20">
          <v-flex id="ttt">
            <v-btn class="mt-4">나이대별 통계자료</v-btn>
            <v-container class="fill-height" fluid>
              <!-- <v-row align="center" justify="center"> -->
              <test-random style="width:100%;"></test-random>
              <!-- </v-row> -->
              <!-- <v-row align="center" justify="center"></v-row> -->
            </v-container>
          </v-flex>
        </v-card>
      </v-col>

      <v-flex mb-5 xs12 id="aac">
        <!-- <h2 class="headline font-weight-bold mb-3">What's next?</h2> -->
        <v-btn class="mt-4">월별 통계자료</v-btn>
        <v-container class="fill-height" fluid>
          <!-- <v-row align="center" justify="center"> -->
          <test-bar style="width:100%;"></test-bar>
          <!-- </v-row> -->
        </v-container>
      </v-flex>

      <v-col>
        
        <v-card class="mt-4 mx-auto" elevation="20">
          <check-rooms></check-rooms>
        </v-card>
      </v-col>
    </v-layout>
  </v-container>


  <!-- <v-sheet
  class="v-sheet--offset mx-auto"
  color="cyan"
  elevation="12"
  max-width="calc(100% - 32px)"
>
  <v-sparkline :labels="labels" :value="value" color="white" line-width="2" padding="16"></v-sparkline>
</v-sheet>

<v-card-text class="pt-0">
  <div class="title font-weight-light mb-2">User Registrations</div>
  <div class="subheading font-weight-light grey--text">Last Campaign Performance</div>
  <v-divider class="my-2"></v-divider>
  <v-icon class="mr-2" small>mdi-clock</v-icon>
  <span class="caption grey--text font-weight-light">last registration 26 minutes ago</span>
</v-card-text> -->
</template>


<script>
import { mixins, Line, Bar, HorizontalBar } from "vue-chartjs";

let lineTest = {
  extends: Line,
  mixins: [mixins.reactiveData],
  data: () => ({
    chartData: "",
    options: {
      scales: {
        xAxes: [
          {
            gridLines: {
              display: false
            }
          }
        ],
        yAxes: [
          {
            gridLines: {
              display: false
            }
          }
        ]
      },
      responsive: true,
      maintainAspectRatio: false
    }
  }),
  created() {
    this.fillData();
  },
  mounted() {
    this.renderChart(this.chartData, this.options);

    setInterval(() => {
      this.fillData();
    }, 1000);
  },
  methods: {
    fillData() {
      this.chartData = {
        labels: [
          "1월" + this.getRandomInt(),
          "2월",
          "3월",
          "4월",
          "5월",
          "6월",
          "7월",
          "8월",
          "9월",
          "10월",
          "11월",
          "12월"
        ],
        datasets: [
          {
            label: "Data One",
            // backgroundColor: "#eccc68",
            backgroundColor: '#'+(Math.random()*0xFFFFFF<<0).toString(16),
            data: [
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt()
            ]
          }
        ]
      };
    },
    getRandomInt() {
      return Math.floor(Math.random() * (50 - 5 + 1)) + 5;
    }
  }
};

let barTest = {
  extends: Bar,
  mixins: [mixins.reactiveData],
  data: () => ({
    chartData: "",
    options: {
      scales: {
        xAxes: [
          {
            gridLines: {
              display: false
            }
          }
        ],
        yAxes: [
          {
            gridLines: {
              display: false
            }
          }
        ]
      },
      responsive: true,
      maintainAspectRatio: false
    }
  }),
  created() {
    this.fillData();
  },
  mounted() {
    this.renderChart(this.chartData, this.options);

    setInterval(() => {
      this.fillData();
    }, 10000);
  },
  methods: {
    fillData() {
      this.chartData = {
        labels: [
          "January" + this.getRandomInt(),
          "February",
          "March",
          "April",
          "May",
          "June",
          "July",
          "August",
          "September",
          "October",
          "November",
          "December"
        ],
        datasets: [
          {
            label: "Data One",
            backgroundColor: function(hex) {
              return '#'+(Math.random()*0xFFFFFF<<0).toString(16);
            },
            data: [
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt()
            ]
          }
        ]
      };
    },
    getRandomInt() {
      return Math.floor(Math.random() * (50 - 5 + 1)) + 5;
    }
  }
};

let randomTest = {
  extends: HorizontalBar,
  mixins: [mixins.reactiveData],
  data: () => ({
    chartData: "",
    options: {
      responsive: true,
      maintainAspectRatio: false
    }
  }),
  created() {
    this.fillData();
  },
  mounted() {
    this.renderChart(this.chartData, this.options);

    setInterval(() => {
      this.fillData();
    }, 10000);
  },
  methods: {
    fillData() {
      this.chartData = {
        labels: [
          "January" + this.getRandomInt(),
          "February",
          "March",
          "April",
          "May",
          "June",
          "July",
          "August",
          "September",
          "October",
          "November",
          "December"
        ],
        datasets: [
          {
            label: "Data One",
            backgroundColor: "#FEA47F",
            data: [
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt(),
              this.getRandomInt()
            ]
          }
        ]
      };
    },
    getRandomInt() {
      return Math.floor(Math.random() * (50 - 5 + 1)) + 5;
    }
  }
};
import checkRoom from './CheckRooms';

export default {
  data: () => ({
    labels: ["12am", "3am", "6am", "9am", "12pm", "3pm", "6pm", "9pm"],
    value: [200, 675, 410, 390, 310, 460, 250, 240]
  }),
  components: {
    testLine: lineTest,
    testBar: barTest,
    testRandom: randomTest,
    checkRooms:checkRoom
  }
};
</script>
<style scoped>
#tte {
  background-color: #9aecdb;
  height: 500px;
}
#ttt {
  background-color: #81ecec;
  height: 500px;
}
#aac {
  background-color: bisque;
  height: 500px;
}
.v-sheet--offset {
  top: -24px;
  position: relative;
}
</style>
