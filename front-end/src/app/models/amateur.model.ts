export class Amateur {
  constructor(
        private _id: number | null,
        private _name: string,
        private _email: string,
        private _yearsOfExperience: number,
        private _password: string,
        private _photo: string = './assets/img/user.png',

  ) { }

    public get yearsOfExperience(): number {
        return this._yearsOfExperience;
    }
    public set yearsOfExperience(value: number) {
        this._yearsOfExperience = value;
    }

    public get photo(): string {
        return this._photo;
    }
    public set photo(value: string) {
        this._photo = value;
    }
    public get password(): string {
        return this._password;
    }
    public set password(value: string) {
        this._password = value;
    }
    public get email(): string {
        return this._email;
    }
    public set email(value: string) {
        this._email = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get id(): number | null {
        return this._id;
    }
    public set id(value: number | null) {
        this._id = value;
    }

    public toJSON(): any {
        return {
            id: this._id,
            name: this._name,
            email: this._email,
            yearsOfExperience: this._yearsOfExperience,
            password: this._password,
            photo: this._photo,

        };
    }

}