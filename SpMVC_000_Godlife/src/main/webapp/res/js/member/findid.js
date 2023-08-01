document.addEventListener("DOMContentLoaded", () => {
  const msg_divs = document.querySelectorAll("div.msg_div");
  const join_inputs = document.querySelectorAll(".contain input");
  const findId = async (e) => {
    const input_tel = join_inputs[0].value;
    // console.log(input_tel);

    const idcheck_url = `${rootPath}/member/findId/search?tel=${input_tel}`;
    const respnse = await fetch(idcheck_url);
    const result = await respnse.text();
    console.log(result);
    // msg(result);
    return result;
  };
  document.querySelector("#findId_next")?.addEventListener("click", findId);

  const msg = (result) => {
    if (result === "FAIL") {
      const nav_text = "* 가입된 이메일이 없습니다";
      msg_divs[0].style.display = "block";
      msg_divs[0].textContent = nav_text;
      msg_divs[0].style.color = "tomato";
      join_inputs[0].focus();
      return false;
    }
  };
});
