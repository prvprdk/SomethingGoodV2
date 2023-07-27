import Vue from 'vue'
import vuetify from 'plugins/vuetify'
import 'api/resource'
import '@babel/polyfill'
import App from 'pages/App.vue'
import {connect} from './util/ws'
import store from 'store/store'
import router from 'router/router'

if (frontendData.profile){
connect()
}

new Vue ({
el: '#app',
store,
vuetify,
router,
render: a => a(App)
})




