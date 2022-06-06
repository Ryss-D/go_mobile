package go_mobile

import "math/rand"

type(
    Go_mobile struct {}
)

func (p *Go_mobile) RandomNumber() int {
    return rand.Intn(100);
}
