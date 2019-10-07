import Vue from 'vue'
import Router from 'vue-router'
import store from './store'
Vue.use(Router);

//enter Path
const requireAuth = () => (to, from, next) => {
  if (store.state.loginPermission == 1) {
    return next();
  }
  next({path:'/login'});
};



const userBoards = [
  {
    path:'/',
    name:'userBoard',
    component:()=> import(/* webpackChunkName: "about" */ './views/user/board/BoardList.vue')
  },
  {
    path:'createNew',
    name:'userBoardCreate',
    props:true,
    component:()=> import(/* webpackChunkName: "create" */ './views/user/board/BoardCreate.vue')
  },
  {
    path:'update',
    name:'userBoardUpdate',
    component:()=> import(/* webpackChunkName: "update" */ './views/user/board/BoardUpdate.vue')
  },
  {
    path:'detail',
    name:'userBoardDetail',
    props:true,
    component:()=> import(/* webpackChunkName: "detail" */ './views/user/board/BoardDetail.vue')
  }
];

const userDefault = [
  {
    path:'/',
    name:'userHome',
    component:()=>import(/* webpackChunkName: "abouts" */ './views/user/UserHome.vue'),
  },
  {
    path:'reservate',
    name:'userReservation',
    component:()=>import(/* webpackChunkName: "reservate" */ './views/user/UserReservation.vue'),
  },
  {
    path:'smalltalk',
    component:()=>import(/* webpackChunkName: "smalltalk" */ './views/user/UserBoard.vue'),
    children:userBoards
  },
  {
    path:'hotelInfo',
    name:'hotelInfo',
    component:()=>import(/* webpackChunkName: "hotelInfo" */ './views/user/HotelInfo.vue'),
  },
  {
    path:'userInfo',
    name:'userInfo',
    component:()=>import(/* webpackChunkName: "userInfo" */ './views/user/UserInfo.vue'),
  },
  {
    path:'reserveNew',
    name:'reservationNew',
    component:()=>import(/* webpackChunkName: "reserveNew" */ './views/user/reservate/ReservationCom.vue'),    
  },
  {
    path:'reserveComf',
    name:'reserveComf',
    component:()=>import(/* webpackChunkName: "reserveNew" */ './views/user/reservate/ReserveConfirm.vue'),    
  }
]

const adminDefault = [
  {
    path:'/',
    name:'adminHome2',
    component:()=>import(/* webpackChunkName: "admin" */ './components/HelloWorld.vue'),
  },
  {
    path:'setting',
    name:'adminSetting',
    component:()=>import(/* webpackChunkName: "admin/setting" */ './views/admin/AdminSetting.vue'),
  },
  {
    path:'priceControl',
    name:'adminPrice',
    component:()=>import(/* webpackChunkName: "admin/priceControl" */ './views/admin/AdminPrice.vue'),
  },
  {
    path:'nowdate',
    name:'adminNow',
    component:()=>import(/* webpackChunkName: "admin/nowdate" */ './views/admin/AdminNow.vue'),
  },
  {
    path:'contact',
    name:'adminContact',
    component:()=>import(/* webpackChunkName: "admin/contact" */ './views/admin/AdminContact.vue'),
  }
]

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path:'/login',
      name:'login',
      component: () => import(/* webpackChunkName: "login" */ './views/Login.vue')
    },
    {
      path: '/admin',
      beforeEnter:requireAuth(),
      component: () => import(/* webpackChunkName: "admin" */ './views/admin/AdminHome.vue'),
      children:adminDefault
    },
    {
      path: '/',
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue'),
      children:userDefault
    }
  ]
})
