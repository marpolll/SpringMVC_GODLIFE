document.addEventListener("DOMContentLoaded", () => {
  console.log("recommend");
  const add_challenge_box = document.querySelector("button#add_challenge");
  const challenge_list_box = document.querySelector(
    "div.challenge.challenge_box"
  );
  const challenge_water = document.querySelector("span#water");
  const challenge_zero = document.querySelector("span#zero");
  const challenge_book = document.querySelector("span#book");
  const challenge_dairy = document.querySelector("span#dairy");
  const challenge_bedding = document.querySelector("span#bedding");
  const challenge_running = document.querySelector("span#running");
  const challenge_list = document.querySelector("div.challenge_list");

  const challengeClickHandler = (e) => {
    const challenge_input_list = document.querySelectorAll(
      "div.challenge_list input"
    );
    const challenge_box = e.target;
    if (challenge_box.tagName !== "SPAN") {
      return false;
    }
    const id = challenge_box.dataset.id;
    const text = challenge_box.textContent;
    const check = challenge_input_list.length;
    // console.log(id);
    // console.log(check);

    // const challenge_div = document.createElement();
    if (check < 2) {
      // input 태그를 만든다.
      var $input = document.createElement("input");
      // 태그의 id를 설정한다.
      $input.id = "u_challenge2";
      // 태그의 type을 설정한다.
      $input.type = "textbox";
      // 태그의 value를 설정한다.
      $input.value = text;
      // 태그의 placeholder를 설정한다
      $input.placeholder = "일정을 추가해주세요.";
      // body에 가장 아래, 즉 </body>태그의 바로 위에 input 태그를 푸가한다.
      challenge_list?.appendChild($input);
    } else if (check < 3) {
      var $input = document.createElement("input");
      $input.id = "u_challenge3";
      $input.type = "textbox";
      $input.value = text;
      $input.placeholder = "일정을 추가해주세요.";
      challenge_list?.appendChild($input);
    }
    // challenge_list.appendChild(challenge_div);
  };
  challenge_list_box?.addEventListener("click", challengeClickHandler);

  const addChallengeClickHandler = (e) => {
    const challenge_input_list = document.querySelectorAll(
      "div.challenge_list input"
    );
    const challenge_box = e.target;
    if (challenge_box.tagName !== "BUTTON") {
      return false;
    }

    const check = challenge_input_list.length;
    if (check < 2) {
      var $input = document.createElement("input");
      $input.id = "u_challenge2";
      $input.type = "textbox";
      $input.placeholder = "일정을 추가해주세요.";
      challenge_list?.appendChild($input);
    } else if (check < 3) {
      var $input = document.createElement("input");
      $input.id = "u_challenge3";
      $input.type = "textbox";
      $input.placeholder = "일정을 추가해주세요.";
      challenge_list?.appendChild($input);
    }
  };
  add_challenge_box?.addEventListener("click", addChallengeClickHandler);
});
