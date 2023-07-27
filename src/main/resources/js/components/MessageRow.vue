<template>
<div>
     <v-img
      class="mt-12 mx-auto"
      text-align
       max-height="300"
       max-width="500"
       src="https://raw.githubusercontent.com/prvprdk/SomethingGood/main/somethinggood/src/main/resources/static/her.png"
     >
     </v-img>

     <v-row class="d-flex justify-center">
        <div class=" text-h6 mt-12 mx-auto" text-align rounded>
            {{randomMessage.text}}
            </div>
      </v-row>
       <v-row>
           <v-btn class="mt-12 mx-auto" text-align rounded @click="random">
                get random good message
           </v-btn>
       </v-row>
         <v-row>
                   <div class="   mt-12 mx-auto" text-align rounded>
                        {{messages.length}} good messages for ya
                             </div>
          </v-row>
       <v-row >
                   <div class="   mt-12 mx-auto" text-align rounded> back to set
                             <v-btn  @click="$router.push('/set')" icon> <v-icon>undo</v-icon> </v-btn>
                    </div>
       </v-row>


</div>

</template>

<script>

import { mapState } from 'vuex'
 export default{
   computed: mapState(['profile', 'messages']),
     data() {
                 return {
                 randomMessage: '',

                 }
             },
   methods: {
                random() {
                this.randomMessage =  this.messages[Math.ceil(Math.random()*(this.messages.length-1))]
                      }
                     },

}
</script>
<style>
</style>