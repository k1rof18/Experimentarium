fn main() {
    let mut g = Game::new();
    g.add(5);
    g.add(4);
    assert_eq!(9, g.score());
}

#[derive(Clone, Copy, Debug)]
struct Game {
    scorer: Scorer,
    its_current_frame: i32,
    first_throw_in_frame: bool,
}

impl Game {
    pub fn new() -> Self {
        Game {
            scorer: Scorer::new(),
            its_current_frame: 0,
            first_throw_in_frame: true,
        }
    }

    pub fn score(&mut self) -> i32 {
        self.score_for_frame(self.its_current_frame)
    }

    pub fn add(&mut self, pins: i32) {
        self.scorer.add_throw(pins);
        self.adjust_current_frame(pins);
    }

    fn adjust_current_frame(&mut self, pins: i32) {
        if self.last_ball_in_frame(pins) {
            self.advance_frame();
        } else {
            self.first_throw_in_frame = false;
        }
    }

    fn last_ball_in_frame(&mut self, pins: i32) -> bool {
        self.strike(pins) || !self.first_throw_in_frame
    }

    fn advance_frame(&mut self) {
        self.its_current_frame += 1;
        self.its_current_frame = std::cmp::min(10, self.its_current_frame + 1);
    }

    fn score_for_frame(&mut self, the_frame: i32) -> i32 {
        self.scorer.score_for_frame(the_frame)
    }

    fn strike(&mut self, pins: i32) -> bool {
        self.first_throw_in_frame && pins == 10
    }
}

#[derive(Clone, Copy, Debug)]
struct Scorer {
    ball: usize,
    its_throws: [i32; 21],
    its_current_throw: usize,
}

impl Scorer {
    fn new() -> Self {
        Scorer {
            ball: 0,
            its_throws: [0; 21],
            its_current_throw: 0,
        }
    }

    fn add_throw(&mut self, pins: i32) {
        self.its_throws[self.its_current_throw] = pins;
        self.its_current_throw += 1;
    }

    fn score_for_frame(&mut self, the_frame: i32) -> i32 {
        self.ball = 0;
        let mut score = 0;
        for _ in 0..the_frame {
            if self.strike() {
                score += 10 + self.next_two_balls_strike();
                self.ball += 1;
            } else if self.spare() {
                score += self.next_ball_for_spare() + 10;
                self.ball += 2;
            } else {
                score += self.two_balls_in_frame();
                self.ball += 2;
            }
        }
        score
    }

    fn strike(self) -> bool {
        self.its_throws[self.ball] == 10
    }
    fn spare(self) -> bool {
        self.its_throws[self.ball] + self.its_throws[self.ball + 1] == 10
    }
    fn next_two_balls_strike(self) -> i32 {
        self.its_throws[self.ball + 1] + self.its_throws[self.ball + 2]
    }
    fn next_ball_for_spare(self) -> i32 {
        self.its_throws[self.ball + 2]
    }
    fn two_balls_in_frame(self) -> i32 {
        self.its_throws[self.ball] + self.its_throws[self.ball + 1]
    }
}

#[test]
fn test_two_throws_no_marks() {
    let mut g = Game::new();
    g.add(5);
    g.add(4);
    assert_eq!(9, g.score());
}

#[test]
fn test_four_throws_no_marks() {
    let mut g = Game::new();
    g.add(5);
    g.add(4);
    g.add(7);
    g.add(2);
    assert_eq!(18, g.score());
    assert_eq!(9, g.score_for_frame(1));
    assert_eq!(18, g.score_for_frame(2));
}

#[test]
fn test_simple_spare() {
    let mut g = Game::new();
    g.add(3);
    g.add(7);
    g.add(3);
    assert_eq!(13, g.score_for_frame(1));
}

#[test]
fn test_simple_frame_after_spare() {
    let mut g = Game::new();
    g.add(3);
    g.add(7);
    g.add(3);
    g.add(2);
    assert_eq!(13, g.score_for_frame(1));
    assert_eq!(18, g.score_for_frame(2));
    assert_eq!(18, g.score());
}

#[test]
fn test_simple_strike() {
    let mut g = Game::new();
    g.add(10);
    g.add(3);
    g.add(6);
    assert_eq!(19, g.score_for_frame(1));
    assert_eq!(28, g.score());
}

#[test]
fn test_perfect_game() {
    let mut g = Game::new();

    for _ in 0..12 {
        g.add(10);
    }
    assert_eq!(300, g.score());
}

#[test]
fn test_end_of_arr() {
    let mut g = Game::new();
    for _ in 0..9 {
        g.add(0);
    }
    g.add(2);
    g.add(8);
    g.add(10);
    assert_eq!(20, g.score());
}

#[test]
fn test_sample_game() {
    let mut g = Game::new();
    g.add(1);
    g.add(4);
    g.add(4);
    g.add(5);
    g.add(6);
    g.add(4);
    g.add(5);
    g.add(5);
    g.add(10);
    g.add(0);
    g.add(1);
    g.add(7);
    g.add(3);
    g.add(6);
    g.add(4);
    g.add(10);
    g.add(2);
    g.add(8);
    g.add(6);
    assert_eq!(133, g.score());
}

#[test]
fn test_heart_break() {
    let mut g = Game::new();
    for _ in 0..11 {
        g.add(10);
    }
    g.add(9);
    assert_eq!(299, g.score());
}

#[test]
fn test_tenth_frame_spare() {
    let mut g = Game::new();
    for _ in 0..9 {
        g.add(10);
    }
    g.add(9);
    g.add(1);
    g.add(1);
    assert_eq!(270, g.score());
}
