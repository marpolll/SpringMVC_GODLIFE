const INPUT_INDEX = {
  EMAIL: 0,
  PASSWORD: 1,
  RE_PASSWORD: 2,
  USERNAME: 3,
  NICKNAME: 4,
  TEL: 5,
  BIRTH: 6,
};

document.addEventListener("DOMContentLoaded", () => {
  const msg_divs = document.querySelectorAll("div.msg_div");
  const join = async () => {
    // asyncReturn().then((value) => console.log("value1: ", value));
    const join_inputs = document.querySelectorAll(".contain input");
    const input_email = join_inputs[INPUT_INDEX.EMAIL].value;
    if (!input_email) {
      const nav_text = "* 이메일을 입력해주세요";
      msg_divs[INPUT_INDEX.EMAIL].style.display = "block";
      msg_divs[INPUT_INDEX.EMAIL].textContent = nav_text;
      msg_divs[INPUT_INDEX.EMAIL].style.color = "tomato";
      join_inputs[INPUT_INDEX.EMAIL].focus();
      return false;
    }
    const email_check =
      /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (!email_check.test(input_email)) {
      const nav_text = "* 이메일 형식을 맞춰서 입력해주세요";
      msg_divs[INPUT_INDEX.EMAIL].style.display = "block";
      msg_divs[INPUT_INDEX.EMAIL].textContent = nav_text;
      msg_divs[INPUT_INDEX.EMAIL].style.color = "tomato";
      join_inputs[INPUT_INDEX.EMAIL].focus();
      return false;
    }
    msg_divs[INPUT_INDEX.EMAIL].style.display = "none";

    const res = await fetch(
      `${rootPath}/member/id_check?u_email=${input_email}`
    );
    const json = await res.json();
    console.log(json);
    if (json.u_email === "USE_EMAIL") {
      const nav_text = "* 등록된 이메일 입니다.";
      msg_divs[INPUT_INDEX.EMAIL].style.display = "block";
      msg_divs[INPUT_INDEX.EMAIL].textContent = nav_text;
      msg_divs[INPUT_INDEX.EMAIL].style.color = "tomato";
      join_inputs[INPUT_INDEX.EMAIL]?.select();
      return false;
    }

    const input_password = join_inputs[INPUT_INDEX.PASSWORD].value;
    if (!input_password) {
      const nav_text = "* 비밀번호를 입력해주세요.";
      msg_divs[INPUT_INDEX.PASSWORD].style.display = "block";
      msg_divs[INPUT_INDEX.PASSWORD].textContent = nav_text;
      msg_divs[INPUT_INDEX.PASSWORD].style.color = "tomato";
      join_inputs[INPUT_INDEX.PASSWORD].focus();
      return false;
    }
    const password_check =
      /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
    if (!password_check.test(input_password)) {
      const nav_text =
        "* 비밀번호는 8~15자로 특수문자, 영문, 숫자를 입력해주세요.";
      msg_divs[INPUT_INDEX.PASSWORD].style.display = "block";
      msg_divs[INPUT_INDEX.PASSWORD].textContent = nav_text;
      msg_divs[INPUT_INDEX.PASSWORD].style.color = "tomato";
      join_inputs[INPUT_INDEX.PASSWORD].focus();
      return false;
    }
    msg_divs[INPUT_INDEX.PASSWORD].style.display = "none";

    const input_re_password = join_inputs[INPUT_INDEX.RE_PASSWORD].value;
    if (!input_re_password) {
      const nav_text = "* 비밀번호 확인을 입력해주세요.";
      msg_divs[INPUT_INDEX.RE_PASSWORD].style.display = "block";
      msg_divs[INPUT_INDEX.RE_PASSWORD].textContent = nav_text;
      msg_divs[INPUT_INDEX.RE_PASSWORD].style.color = "tomato";
      join_inputs[INPUT_INDEX.RE_PASSWORD].focus();
      return false;
    }
    if (input_password !== input_re_password) {
      const nav_text = "* 비밀번호와 동일하게 입력해주세요.";
      msg_divs[INPUT_INDEX.RE_PASSWORD].style.display = "block";
      msg_divs[INPUT_INDEX.RE_PASSWORD].textContent = nav_text;
      msg_divs[INPUT_INDEX.RE_PASSWORD].style.color = "tomato";
      join_inputs[INPUT_INDEX.RE_PASSWORD].value = "";
      join_inputs[INPUT_INDEX.RE_PASSWORD].focus();
      return false;
    }
    msg_divs[INPUT_INDEX.RE_PASSWORD].style.display = "none";

    const input_tel = join_inputs[INPUT_INDEX.TEL].value;
    if (!input_tel) {
      const nav_text = "* 전화번호를 입력해주세요.";
      msg_divs[INPUT_INDEX.TEL].style.display = "block";
      msg_divs[INPUT_INDEX.TEL].textContent = nav_text;
      msg_divs[INPUT_INDEX.TEL].style.color = "tomato";
      join_inputs[INPUT_INDEX.TEL].focus();
      return false;
    }
    const tel_check = /^\d{3}-\d{3,4}-\d{4}$/;
    if (!tel_check.test(input_tel)) {
      const nav_text =
        "* 전화번호를 형식에 맞춰서 입력해주세요. ex)000-0000-0000";
      msg_divs[INPUT_INDEX.TEL].style.display = "block";
      msg_divs[INPUT_INDEX.TEL].textContent = nav_text;
      msg_divs[INPUT_INDEX.TEL].style.color = "tomato";
      join_inputs[INPUT_INDEX.TEL].focus();
      return false;
    }
    msg_divs[INPUT_INDEX.TEL].style.display = "none";

    const input_birth = join_inputs[INPUT_INDEX.BIRTH].value;
    const birth_check = /^\d{4}-\d{2}-\d{2}$/;
    if (!birth_check.test(input_birth)) {
      const nav_text = "* 생년월일을 형식에 맞춰서 입력해주세요. ex)1999-01-01";
      msg_divs[INPUT_INDEX.BIRTH].style.display = "block";
      msg_divs[INPUT_INDEX.BIRTH].textContent = nav_text;
      msg_divs[INPUT_INDEX.BIRTH].style.color = "tomato";
      join_inputs[INPUT_INDEX.BIRTH].focus();
      return false;
    }
    msg_divs[INPUT_INDEX.BIRTH].style.display = "none";

    document.querySelector("form.main").submit();
    return false;
  };

  // 클릭이벤트
  document.querySelector("#login_btn")?.addEventListener("click", join);

  // const saveData = async (e) => {
  //   // saveData().then((value) => console.log("value1: ", value));
  //   const join_inputs = document.querySelectorAll(".contain input");
  //   const input_email = join_inputs[INPUT_INDEX.EMAIL].value;
  //   const input_password = join_inputs[INPUT_INDEX.PASSWORD].value;
  //   const input_name = join_inputs[INPUT_INDEX.USERNAME].value;
  //   const input_tel = join_inputs[INPUT_INDEX.TEL].value;
  //   const input_birth = join_inputs[INPUT_INDEX.BIRTH].value;

  //   const idcheck_url = `${rootPath}/member/join_save?u_email=${input_email}&u_password=${input_password}&u_name=${input_name}&u_tel=${input_tel}&u_birth=${input_birth}`;
  //   const respnse = await fetch(idcheck_url);
  //   const result = await respnse.text();
  //   console.log(result);
  //   return result;
  // };
});

const check_data = function () {
  const emailText = g_email.value;

  if (!emailText) {
    g_email.style.border = "1px solid #ff1212";
    return false;
  } else {
    g_email.style.border = "1px solid mediumseagreen";
  }

  // document.querySelector("#login_btn").addEventListener("click", join);
};
