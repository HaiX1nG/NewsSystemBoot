<script>
export default {
  name: "FooterUrl"
}
</script>

<template>
  <div id="main">
    <table>
      <tr>
        <td>
          <a href="#">&nbsp;国家科技部&nbsp;</a>
        </td>
        <td></td>
        <td>
          <a href="#">&nbsp;国家知识产权局&nbsp;</a>
        </td>
        <td></td>
        <td>
          <a href="#">&nbsp;江西省科技厅&nbsp;</a>
        </td>
        <td></td>
        <td>
          <a href="#">&nbsp;江西省知识产权局&nbsp;</a>
        </td>
        <td></td>
        <td>
          <a href="#">&nbsp;南昌市科技局&nbsp;</a>
        </td>
        <td></td>
        <td>
          <a href="#">&nbsp;江西外语外贸职业学院&nbsp;</a>
        </td>
        <td></td>
        <td>
          <a href="#">&nbsp;江西外语外贸学院科研处&nbsp;</a>
        </td>
      </tr>
    </table>
  </div>
</template>

<style scoped>
* {
  margin: 0;
  padding: 0;
  font-family: "Microsoft YaHei",serif;
}

#main {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background-color: white;
}

#main > table {
  width: 100%;
  height: 24px;
  text-align: center;
}

#main > table > tbody {
  display: table-row-group;
  vertical-align: middle;
  border-color: inherit;
}

#main > table > tr > td > a {
  text-decoration: none;
  color: #222222;
}

#main > table > tr > td > a:hover {
  color: #cc0000 !important;
}
</style>