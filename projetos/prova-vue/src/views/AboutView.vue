<template>
  <div class="about">
    <h1>Eu sou o cara! Me chamo {{ nome }}</h1>
    <input type="text" v-model="nome" />
    <p v-if="nome.length > 5"> Nome muito grande! </p>
    <p v-else> Nome pequeno! </p>
    <label for="nome">Nome: </label>
    <input id="nome" type="text" v-model="nome" />
    <label for="senha">Senha: </label>
    <input id="senha" type="password" v-model="senha" />
    <button @click="cadastrar">Cadastrar</button>
    
    <table>
    <thead>
      <td>Id</td>
      <td>Nome</td>  
    </thead>
    <tr v-for="usuario in usuarios" :key="usuario.id">
      <td>{{ usuario.id }}</td>
      <td>{{ usuario.nome}}</td>
    </tr>
    </table>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue'
import axios from 'axios'

const nome = ref("");
const senha = ref("");
const usuarios = ref();

async function atualizar(){
  usuarios.value = (await axios.get("http://localhost:8080/usuario")).data;
}

async function cadastrar(){
  await axios.post("http://localhost:8080/usuario",
  {
    nome: nome.value,
    senha: senha.value
  });
  atualizar();
}

onMounted(() => {
  atualizar();

});

</script>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
