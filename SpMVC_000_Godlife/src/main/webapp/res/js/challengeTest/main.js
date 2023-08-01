document.addEventListener("DOMContentLoaded", () => {
  const plus_btnList = document.querySelectorAll(".challenge .button_add");
  plus_btnList.forEach((plus_btn) => {
    plus_btn.addEventListener("click", () => {
      //   console.log(plus_btn.dataset.id);
      plus_btnNum = plus_btn.dataset.id;
      const target_ct = document.querySelector(`.challenge.ct${plus_btnNum}`);
      target_ct.innerHTML = parseInt(target_ct.innerHTML) + 1;
      const target_pg = document.querySelector(`.challenge.pg${plus_btnNum}`);
      target_pg.value = target_pg.value + 1;
      console.log(target_pg.value);
    });
  });
});
