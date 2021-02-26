<template>
  <div class="create">
    <b-container fluid>
      <div class="row">
        <b-col cols="12" sm="8">
          <b-card class="mt-3" header="Form">
            <validation-observer v-slot="{ reset }">
              <b-form @submit.prevent="handeleSubmit" @reset.prevent="handleReset(reset)">

                <b-form-group label="Tipo Persona">
                  <b-form-select v-model="personType" :options="personTypeOptions" @change="handleReset(reset)">
                    <!-- This slot appears above the options from 'options' prop -->
                    <template #first>
                      <b-form-select-option :value="null" disabled>-- Seleziona un tipo --</b-form-select-option>
                    </template>
                  </b-form-select>
                </b-form-group>

                <b-form-group v-if="isPhysicalPerson" label="Cognome">
                  <validation-provider name="cognome" rules="required" v-slot="{errors, valid, dirty}">
                    <b-form-input
                      v-model="form.denCognome"
                      placeholder="Inserisci cognome"
                      :state="dirty ? valid : null"
                    ></b-form-input>
                    <!-- This will only be shown if the preceding input has an invalid state -->
                    <b-form-invalid-feedback>{{ errors[0] }}</b-form-invalid-feedback>
                  </validation-provider>
                </b-form-group>

                <b-form-group v-if="isPhysicalPerson" label="Nome">
                  <validation-provider name="nome" rules="required" v-slot="{errors, valid, dirty}">
                    <b-form-input
                      v-model="form.denNome"
                      placeholder="Inserisci nome"
                      :state="dirty ? valid : null"
                    ></b-form-input>
                    <b-form-invalid-feedback>{{ errors[0] }}</b-form-invalid-feedback>
                  </validation-provider>
                </b-form-group>

                <b-form-group v-if="isPhysicalPerson" label="Email">
                  <validation-provider name="email" rules="email" v-slot="{errors, valid, dirty}">
                    <b-form-input
                      v-model="form.denEmail"
                      placeholder="Inserisci email"
                      :state="dirty ? valid : null"
                    ></b-form-input>
                    <b-form-invalid-feedback>{{ errors[0] }}</b-form-invalid-feedback>
                  </validation-provider>
                </b-form-group>

                <b-form-group v-if="isPhysicalPerson" label="Codice Fiscale">
                  <validation-provider name="codice fiscale" rules="required" v-slot="{errors, valid, dirty}">
                    <b-form-input
                      v-model="form.codFiscale"
                      placeholder="Inserisci codice fiscale"
                      :state="dirty ? valid : null"
                    ></b-form-input>
                    <b-form-invalid-feedback>{{ errors[0] }}</b-form-invalid-feedback>
                  </validation-provider>
                </b-form-group>

                <b-form-group v-if="isPhysicalPerson" label="Data di nascita">
                  <validation-provider name="data di nascita" rules="required" v-slot="{errors, valid, dirty}">
                    <b-form-datepicker 
                      v-model="form.dataNascita"
                      placeholder="Seleziona una data"
                      :state="dirty ? valid : null"
                    ></b-form-datepicker>
                    <b-form-invalid-feedback>{{ errors[0] }}</b-form-invalid-feedback>
                  </validation-provider>
                </b-form-group>

                <b-form-group v-if="isLegalPerson" label="Ragione sociale">
                  <validation-provider name="ragione sociale" rules="required" v-slot="{errors, valid, dirty}">
                    <b-form-input
                      v-model="form.denRagioneSociale"
                      placeholder="Inserisci la ragione sociale"
                      :state="dirty ? valid : null"
                    ></b-form-input>
                    <b-form-invalid-feedback>{{ errors[0] }}</b-form-invalid-feedback>
                  </validation-provider>
                </b-form-group>

                <b-form-group v-if="isLegalPerson" label="Partita iva">
                  <validation-provider name="partita iva" rules="required" v-slot="{errors, valid, dirty}">
                    <b-form-input
                      v-model="form.codPartitaIva"
                      placeholder="Inserisci PIVA"
                      :state="dirty ? valid : null"
                    ></b-form-input>
                    <b-form-invalid-feedback>{{ errors[0] }}</b-form-invalid-feedback>
                  </validation-provider>
                </b-form-group>

                <b-form-group v-if="personType" label="Documento">
                  <validation-provider name="documento" rules="required" v-slot="{errors, valid, dirty}">
                    <b-form-file
                      v-model="file"
                      placeholder="Seleziona un file"
                      :state="dirty ? valid : null"
                    ></b-form-file>
                    <b-form-invalid-feedback>{{ errors[0] }}</b-form-invalid-feedback>
                  </validation-provider>
                </b-form-group>

                <b-button type="submit" variant="primary">Invia</b-button>
                <b-button type="reset" variant="danger">Reset</b-button>
              </b-form>
            </validation-observer>
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
import { ValidationObserver, ValidationProvider, extend, localize } from 'vee-validate';
import { required, email } from 'vee-validate/dist/rules';
import it from 'vee-validate/dist/locale/it.json';
import { SERVICE_BASE_URL } from '../config/AppConfig';

extend('email', email);
extend('required', required);
localize('it', {it});

const TIPO_PERSONA = {
  FISICA: 'Fisica',
  GIURIDICA: 'Giuridica'
}

export default Vue.extend({
  components: {
    ValidationObserver,
    ValidationProvider
  },
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
    handeleSubmit() {
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
    handleReset(validationResetFn) {
      validationResetFn();

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
    },
  },
});
</script>