
<template>
  <div align-content-space-between>
    <v-img
      class="mt-12 mx-auto"
      max-height="300"
      max-width="500"
      src="https://raw.githubusercontent.com/prvprdk/SomethingGood/main/somethinggood/src/main/resources/static/her.png"
    ></v-img>


      <div class="d-flex justify-center">
        <v-text-field
        class="mt-5"
          :style="{ 'max-width': '500px' }"
          label="good message"
          v-model="text"
          solo
          dense
        ></v-text-field>

      </div>
       <v-row class="d-flex justify-center">
      {{error}}

         </v-row>
       <v-row>
              <v-btn class="mt-12 mx-auto" text-align rounded @click="save">
              add good message
              </v-btn>
       </v-row>
       <v-row >
               <div class="mt-12 mx-auto" text-align rounded> back to get
                     <v-btn  @click="$router.push('/')" icon> <v-icon>undo</v-icon> </v-btn>
               </div>
        </v-row>

  </div>
</template>

<script>
import {mapActions} from 'vuex'

 export default {
    data () {
    return {
            text: '',
            error: ''

        }
    },

    methods: {
            ... mapActions (['addMessageAction']),

           save () {
           if (this.text == null || this.text == ''){
             this.error = "field cannot be empty"

            }else {
           const message = {text: this.text}
           this.addMessageAction(message)
           this.text = ''
           this.error = ''
           }
        },
    }
    }
</script>

<style>
</style>