import { Deserializable } from "../interfaces/deserializable-interface";

export class AmazonReport implements Deserializable {
    
    orderDate: Date;
    orderID: number;
    paymentInstrumentType?: string;
    webSite?: string;
    purchaseOrderNumber?: string;
    orderingCustomerEmail?: string;
    shipmentDate?: Date;
    shippingAddressName?: string;
    shippingAddressStreet1?: string;
    shippingAddressStreet2?: string;
    shippingAddressCity?: string;
    shippingAddressState?: string;
    shippingAddressZip?: string;
    orderStatus?: string;
    carrierNameAndTrackingNumber?: string;
    subtotal?: number;
    shippingCharge?: number;
    taxBeforePromotions?: number;
    totalPromotions?: number;
    taxCharged?: number;
    totalCharged?: number;
    buyerName?: string;
    groupName?: string;

    deserialize(input: any): this {
        Object.assign(this, input);
        return this;
    }
}