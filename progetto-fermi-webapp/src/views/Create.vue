<template>
  <div class="create">
    <b-container fluid>
      <div class="row">
        <b-col cols="12" sm="8">
          <b-card class="mt-3" header="Form">
            <b-form @submit.prevent="onSubmit" @reset.prevent="onReset">
              <b-form-group label="Cognome" label-for="surname">
                <b-form-input
                  id="surname"
                  v-model="form.denCognome"
                  placeholder="Inserisci cognome"
                ></b-form-input>
              </b-form-group>

              <b-form-group label="Nome" label-for="name">
                <b-form-input
                  id="name"
                  v-model="form.denNome"
                  placeholder="Inserisci nome"
                ></b-form-input>
              </b-form-group>

              <b-form-group
                label="Email"
                label-for="email"
              >
                <b-form-input
                  id="email"
                  v-model="form.denEmail"
                  placeholder="Inserisci email"
                ></b-form-input>
              </b-form-group>

              <b-form-group
                label="Codice Fiscale"
                label-for="cf"
              >
                <b-form-input
                  id="cf"
                  v-model="form.codFiscale"
                  placeholder="Inserisci codice fiscale"
                ></b-form-input>
              </b-form-group>

              <b-form-group
                label="Data di nascita"
                label-for="data"
              >
                <b-form-datepicker 
                  id="date"
                  v-model="form.dataNascita"
                  placeholder="Seleziona una data"
                ></b-form-datepicker>
              </b-form-group>

              <b-form-group
                id="input-group-4"
                label="Documento"
                label-for="input-4"
              >
                <b-form-file
                  id="input-4"
                  v-model="file"
                  placeholder="Seleziona un file"
                ></b-form-file>
              </b-form-group>

              <b-button type="submit" variant="primary">Invia</b-button>
              <b-button type="reset" variant="danger">Reset</b-button>
            </b-form>
          </b-card>
        </b-col>
        <b-col cols="12" sm="4">
          <b-card class="mt-3" header="Form Data Result">
            <pre class="m-0">{{ form }}</pre>
          </b-card>
        </b-col>
      </div>
    </b-container>
  </div>
</template>

<script>
import Vue from "vue";
import axios from 'axios';
import { SERVICE_BASE_URL } from '../config/AppConfig';

export default Vue.extend({
  data() {
    return {
      form: {
        denEmail: "",
        denNome: "",
        denCognome: "",
        codFisclae: "",
        dataNascita: "",
        tipoRecapito: "001",
        tipoSesso: "M",
        tipoDocumento: "01"
      },
      file: null
    };
  },
  methods: {
    onSubmit() {
      const form = new FormData();
      form.append('file', this.file);
      form.append('data', JSON.stringify(this.form));

      axios.post(`${SERVICE_BASE_URL}/anagrafica`, form)
        .then((response) => {
          console.log(response)
        })
        .catch((error) => {
          console.log(error);
          let message = "Qualcosa è andato storto. Riprova";
          if (error.response.status === 444 && error.response.data.length > 0) {
            message = (error.response.data).join(', ');
          }
          this.$bvToast.toast(message, {
            title: "Ooops",
            variant: "danger"
          });
        })
    },
    onReset() {
      // Reset our form values
      this.form.denEmail = "",
      this.form.denNome = "";
      this.form.denCognome = "";
    },
  },
});
</script>