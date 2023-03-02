function three_x_plus_1(x) {
  let value = x;
  let steps = 0;

  while (value != 1) {
    value = value % 2 == 0 ? value / 2 : 3 * value + 1;
    steps += 1;
  }

  return steps;
}

console.log(three_x_plus_1(15));
