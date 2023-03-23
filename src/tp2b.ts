import { assert } from "https://deno.land/std@0.178.0/testing/asserts.ts";

function syracuse(x: number) {
  let value = x;
  let steps = 0;

  while (value != 1) {
    value = value % 2 == 0 ? value / 2 : 3 * value + 1;
    steps += 1;
  }

  return steps;
}

const expected: [number, number][] = [
  [1, 0],
  [3, 7],
  [6, 8],
  [7, 16],
  [9, 19],
  [12, 9],
  [15, 17],
];

for (const [a, b] of expected) {
  console.log(`Testing that ((3 * ${a}) + 1) leads to 1 in ${b} steps`);
  assert(syracuse(a) == b);
}
