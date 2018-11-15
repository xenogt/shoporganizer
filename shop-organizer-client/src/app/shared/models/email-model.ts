import { Deserializable } from "../interfaces/deserializable-interface";

export class Email implements Deserializable {
    
    emailID?: number;
    emailAddress: string;
    password: string;
    registeredDate?: Date;

    deserialize(input: any): this {
        Object.assign(this, input);
        return this;
    }
}