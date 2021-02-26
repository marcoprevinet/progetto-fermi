<template>
  <div class="create">
    <b-container fluid>
      <div class="row">
        <b-col cols="12" sm="8">
          <b-card class="mt-3" header="Form">
            <b-form @submit.prevent="onSubmit" @reset.prevent="onReset">

              <b-form-group label="Tipo Persona" label-for="type">
                <b-form-select v-model="personType" :options="personTypeOptions">
                  <!-- This slot appears above the options from 'options' prop -->
                  <template #first>
                    <b-form-select-option :value="null" disabled>-- Seleziona un tipo --</b-form-select-option>
                  </template>
                </b-form-select>
              </b-form-group>

              <b-form-group v-if="isPhysicalPerson" label="Cognome" label-for="surname">
                <b-form-input
                  id="surname"
                  v-model="form.denCognome"
                  placeholder="Inserisci cognome"
                ></b-form-input>
              </b-form-group>

              <b-form-group v-if="isPhysicalPerson" label="Nome" label-for="name">
                <b-form-input
                  id="name"
                  v-model="form.denNome"
                  placeholder="Inserisci nome"
                ></b-form-input>
              </b-form-group>

              <b-form-group v-if="isPhysicalPerson" label="Email" label-for="email">
                <b-form-input
                  id="email"
                  v-model="form.denEmail"
                  placeholder="Inserisci email"
                ></b-form-input>
              </b-form-group>

              <b-form-group v-if="isPhysicalPerson" label="Codice Fiscale" label-for="cf">
                <b-form-input
                  id="cf"
                  v-model="form.codFiscale"
                  placeholder="Inserisci codice fiscale"
                ></b-form-input>
              </b-form-group>

              <b-form-group v-if="isPhysicalPerson" label="Data di nascita" label-for="data">
                <b-form-datepicker 
                  id="date"
                  v-model="form.dataNascita"
                  placeholder="Seleziona una data"
                ></b-form-datepicker>
              </b-form-group>

              <b-form-group v-if="isLegalPerson" label="Ragione sociale" label-for="social">
                <b-form-input
                  id="social"
                  v-model="form.denRagioneSociale"
                  placeholder="Inserisci la ragione sociale"
                ></b-form-input>
              </b-form-group>

              <b-form-group v-if="isLegalPerson" label="Partita iva" label-for="piva">
                <b-form-input
                  id="piva"
                  v-model="form.codPartitaIva"
                  placeholder="Inserisci PIVA"
                ></b-form-input>
              </b-form-group>

              <b-form-group v-if="personType" label="Documento" label-for="doc">
                <b-form-file
                  id="doc"
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

const TIPO_PERSONA = {
  FISICA: 'Fisica',
  GIURIDICA: 'Giuridica'
}

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
        tipoDocumento: "01",
        denRagioneSociale: "",
        codPartitaIva: ""
      },
      file: null,
      personTypeOptions: [TIPO_PERSONA.FISICA, TIPO_PERSONA.GIURIDICA],
      personType: null
    };
  },
  computed: {
    isPhysicalPerson() {
      return this.personType === TIPO_PERSONA.FISICA
    },
    isLegalPerson() {
      return this.personType === TIPO_PERSONA.GIURIDICA
    },
  },
  methods: {
    onSubmit() {
      const form = new FormData();
      form.append('file', this.file);
      form.append('data', JSON.stringify(this.form));

      axios.post(`${SERVICE_BASE_URL}/anagrafica`, form)
        .then((response) => {
          console.log(response);
          this.$bvToast.toast("Anagrafica inserita con successo", {
            title: "OK!",
            variant: "success"
          });
        })
        .catch((error) => {
          console.log(error);
          let message = "Qualcosa è andato storto. Riprova";
          if (error.response.status === 444 && error.response.data.length > 0) {
            message = (error.response.data).join(', ');
          }
          this.$bvToast.toast(message, {
            title: "Ooops!",
            variant: "danger"
          });
        })
    },
    onReset() {
      // Reset our form values
      this.form.denEmail = "";
      this.form.denNome = "";
      this.form.denCognome = "";
      this.form.codFisclae = "";
      this.form.dataNascita = "";
      this.form.tipoRecapito = "";
      this.form.tipoSesso = "";
      this.form.tipoDocumento = "";
      this.form.denRagioneSociale = "";
      this.form.codPartitaIva = "";
      this.file = null;
      this.personType = null;
    },
  },
});
</script>