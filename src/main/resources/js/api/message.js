import Vue from 'vue'

const messages = Vue.resource('/message')

export default {
    add: message => messages.save({}, message)

}